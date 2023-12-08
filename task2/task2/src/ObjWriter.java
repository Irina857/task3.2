import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ObjWriter {

    private Model model;

    public ObjWriter(Model model) {
        this.model = model;
    }

    public void write(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (float[] vertex : model.vertices) {
                writer.write(String.format("v %f %f %f%n", vertex[0], vertex[1], vertex[2]));
            }

            for (float[] textureCoord : model.textureCoords) {
                writer.write(String.format("vt %f %f%n", textureCoord[0], textureCoord[1]));
            }

            for (float[] normal : model.normals) {
                writer.write(String.format("vn %f %f %f%n", normal[0], normal[1], normal[2]));
            }

            for (int[] face : model.faces) {
                writer.write("f");
                for (int vertexIndex : face) {
                    writer.write(String.format(" %d", vertexIndex));
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
