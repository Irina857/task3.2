import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class ObjReaderWriterTestUnit {

    @Test
    void testObjReaderWriter() {
        Model originalModel = createSampleModel();
        ObjWriter objWriter = new ObjWriter(originalModel);
        objWriter.write("output_test.obj");

        ObjReader objReader = new ObjReader();
        Model loadedModel = objReader.read("output_test.obj");

        assertNotNull(loadedModel);
        assertTrue(areModelsEqual(originalModel, loadedModel));
    }

    private void assertNotNull(Model яloadedModel) {

    }

    @Test
    void testFilesEquality() {
        Model originalModel = createSampleModel();
        ObjWriter objWriter = new ObjWriter(originalModel);
        objWriter.write("output_test1.obj");

        ObjReader objReader = new ObjReader();
        Model loadedModel = objReader.read("output_test1.obj");

        ObjWriter objWriter2 = new ObjWriter(loadedModel);
        objWriter2.write("output_test2.obj");

        assertTrue(areFilesEqual("output_test1.obj", "output_test2.obj"));
    }

    private void assertTrue(boolean areFilesEqual) {

    }

    @Test
    void testModelEquality() {
        Model model1 = createSampleModel();
        Model model2 = createSampleModel();

        assertTrue(areModelsEqual(model1, model2));
    }

    private Model createSampleModel() {
        Model model = new Model();
        model.vertices.add(new float[]{0.0f, 0.0f, 0.0f});
        model.vertices.add(new float[]{1.0f, 0.0f, 0.0f});
        model.textureCoords.add(new float[]{0.0f, 0.0f});
        model.textureCoords.add(new float[]{1.0f, 0.0f});
        model.faces.add(new int[]{1, 2});

        return model;
    }

    private boolean areFilesEqual(String filePath1, String filePath2) {
        try {
            List<String> lines1 = Files.readAllLines(Paths.get(filePath1));
            List<String> lines2 = Files.readAllLines(Paths.get(filePath2));

            return lines1.equals(lines2);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean areModelsEqual(Model model1, Model model2) {
        if (model1 == model2) {
            return true;
        }

        if (model1 == null || model2 == null) {
            return false;
        }

        return areFloatArrayListsEqual(model1.vertices, model2.vertices) &&
                areFloatArrayListsEqual(model1.textureCoords, model2.textureCoords) &&
                areIntArrayListsEqual(model1.faces, model2.faces);
    }

    private boolean areFloatArraysEqual(float[] array1, float[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean areFloatArrayListsEqual(List<float[]> list1, List<float[]> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!areFloatArraysEqual(list1.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean areIntArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean areIntArrayListsEqual(List<int[]> list1, List<int[]> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!areIntArraysEqual(list1.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
