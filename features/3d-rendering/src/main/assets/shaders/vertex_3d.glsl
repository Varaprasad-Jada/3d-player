#version 300 es
layout(location = 0) in vec4 position;
layout(location = 1) in vec2 texCoord;
out vec2 fragTexCoord;
out vec4 vertexColor;
uniform mat4 projectionMatrix;
uniform mat4 modelViewMatrix;
uniform mat4 normalMatrix;
void main() {
    gl_Position = projectionMatrix * modelViewMatrix * position;
    fragTexCoord = texCoord;
    vertexColor = vec4(1.0, 1.0, 1.0, 1.0);
}