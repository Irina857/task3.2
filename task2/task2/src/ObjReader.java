import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ObjReader {
    public Model read(String filename) {
        Model model = new Model();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                switch (tokens[0]) {
                    case "v":
                        model.vertices.add(parseVertex(tokens));
                        break;
                    case "vt":
                        model.textureCoords.add(parseTextureCoord(tokens));
                        break;
                    case "vn":
                        model.normals.add(parseNormal(tokens));
                        break;
                    case "f":
                        model.faces.add(parseFace(tokens));
                        break;
                    default:
                        // Ignore other lines
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }

    private float[] parseVertex(String[] tokens) {
        float x = Float.parseFloat(tokens[1].replace(',', '.'));
        float y = Float.parseFloat(tokens[2].replace(',', '.'));
        float z = Float.parseFloat(tokens[3].replace(',', '.'));
        return new float[]{x, y, z};
    }

    private float[] parseTextureCoord(String[] tokens) {
        float x = Float.parseFloat(tokens[1].replace(',', '.'));
        float y = Float.parseFloat(tokens[2].replace(',', '.'));
        return new float[]{x, y};
    }

    private float[] parseNormal(String[] tokens) {
        float x = Float.parseFloat(tokens[1].replace(',', '.'));
        float y = Float.parseFloat(tokens[2].replace(',', '.'));
        float z = Float.parseFloat(tokens[3].replace(',', '.'));
        return new float[]{x, y, z};
    }

    private int[] parseFace(String[] tokens) {
        int[] face = new int[tokens.length - 1];
        for (int i = 1; i < tokens.length; i++) {
            String[] indices = tokens[i].split("/");
            face[i - 1] = Integer.parseInt(indices[0]);
        }
        return face;
    }
}