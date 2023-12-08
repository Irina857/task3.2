import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestSimple {
    public static void main(String[] args) {
        Model model = createSampleModel();

        ObjWriter objWriter = new ObjWriter(model);
        objWriter.write("output_original.obj");

        ObjReader objReader = new ObjReader();
        Model loadedModel = objReader.read("output_original.obj");
        ObjWriter objWriter2 = new ObjWriter(loadedModel);
        objWriter2.write("output_loaded.obj");

        boolean filesAreEqual = areFilesEqual("output_original.obj", "output_loaded.obj");
        System.out.println("Files are equal: " + filesAreEqual);
    }

    private static Model createSampleModel() {
        Model model = new Model();

        model.vertices.add(new float[]{0.0f, 0.0f, 0.0f});
        model.vertices.add(new float[]{1.0f, 0.0f, 0.0f});
        model.vertices.add(new float[]{0.0f, 1.0f, 0.0f});

        model.textureCoords.add(new float[]{0.0f, 0.0f});
        model.textureCoords.add(new float[]{1.0f, 0.0f});
        model.textureCoords.add(new float[]{0.0f, 1.0f});

        model.normals.add(new float[]{0.0f, 0.0f, 1.0f});
        model.normals.add(new float[]{0.0f, 0.0f, 1.0f});
        model.normals.add(new float[]{0.0f, 0.0f, 1.0f});

        model.faces.add(new int[]{1, 2, 3});

        return model;
    }

    private static boolean areFilesEqual(String filePath1, String filePath2) {
        try {
            List<String> lines1 = Files.readAllLines(Paths.get(filePath1));
            List<String> lines2 = Files.readAllLines(Paths.get(filePath2));

            return lines1.equals(lines2);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

