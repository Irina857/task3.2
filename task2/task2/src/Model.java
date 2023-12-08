import java.util.ArrayList;
import java.util.List;

class Model {

    List<float[]> vertices = new ArrayList<>();
    List<float[]> textureCoords = new ArrayList<>();
    List<float[]> normals = new ArrayList<>();
    List<int[]> faces = new ArrayList<>();

    public Model() {

    }

    public Model(List<float[]> vertices, List<float[]> textureCoords, List<float[]> normals, List<int[]> faces) {
        this.vertices = vertices;
        this.textureCoords = textureCoords;
        this.normals = normals;
        this.faces = faces;
    }

    public List<float[]> getVertices() {
        return vertices;
    }

    public void setVertices(List<float[]> vertices) {
        this.vertices = vertices;
    }

    public List<float[]> getTextureCoords() {
        return textureCoords;
    }

    public void setTextureCoords(List<float[]> textureCoords) {
        this.textureCoords = textureCoords;
    }

    public List<float[]> getNormals() {
        return normals;
    }

    public void setNormals(List<float[]> normals) {
        this.normals = normals;
    }

    public List<int[]> getFaces() {
        return faces;
    }

    public void setFaces(List<int[]> faces) {
        this.faces = faces;
    }

}