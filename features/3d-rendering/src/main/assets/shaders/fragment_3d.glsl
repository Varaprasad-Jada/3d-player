#version 300 es
precision mediump float;

// Uniforms for rendering
uniform sampler2D texture1; // Base texture
uniform vec2 resolution; // Resolution of the screen
uniform int mode; // 0: flat, 1: side-by-side, 2: top-bottom, 3: anaglyph, 4: VR

out vec4 fragColor;

void main() {
    vec2 uv = gl_FragCoord.xy / resolution;
    vec4 color = texture(texture1, uv);

    // Add rendering effects based on mode
    if (mode == 0) {
        // Flat rendering
        fragColor = color;
    } 
    else if (mode == 1) {
        // Side-by-side rendering
        if (gl_FragCoord.x < resolution.x / 2.0) {
            fragColor = texture(texture1, uv); // Left eye
        } else {
            fragColor = texture(texture1, vec2(uv.x - 0.5, uv.y)); // Right eye
        }
    } 
    else if (mode == 2) {
        // Top-bottom rendering
        if (gl_FragCoord.y < resolution.y / 2.0) {
            fragColor = texture(texture1, uv); // Top eye
        } else {
            fragColor = texture(texture1, vec2(uv.x, uv.y - 0.5)); // Bottom eye
        }
    } 
    else if (mode == 3) {
        // Anaglyph rendering
        vec4 leftColor = texture(texture1, uv);
        vec4 rightColor = texture(texture1, vec2(uv.x + 0.05, uv.y)); // Offset for right eye
        fragColor = vec4(leftColor.r, rightColor.g, rightColor.b, 1.0);
    } 
    else if (mode == 4) {
        // VR split screen rendering
        if (gl_FragCoord.x < resolution.x / 2.0) {
            fragColor = texture(texture1, uv); // Left eye
        } else {
            fragColor = texture(texture1, vec2(uv.x - 0.5, uv.y)); // Right eye
        }
    }
}