import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("/home/viet/Downloads/dataout");
        File arrFile[] = file.listFiles();
        for (int i = 0; i < arrFile.length; i++) {
            File imageFile = arrFile[i];
            if (imageFile.getName().endsWith(".jpg")) {
                File jpg = new File(imageFile.getAbsolutePath());
                File xml = new File(imageFile.getAbsolutePath().replace(".jpg", ".xml"));
                StringBuilder builder = new StringBuilder();

                FileInputStream inputStream = new FileInputStream(xml);
                int c = inputStream.read();
                while (c != -1) {
                    builder.append((char) c);
                    c = inputStream.read();
                }
//                System.out.println(builder.toString());

                File jpgNew = new File(jpg.getParent() + "/" + (i + 1111) + ".jpg");
                File xmlNew = new File(xml.getParent() + "/" + (i + 1111) + ".xml");

                jpg.renameTo(jpgNew);
                xml.renameTo(xmlNew);

                xmlNew.delete();
                xmlNew.createNewFile();
//                System.out.println(jpgNew.getName()+","+xmlNew.getName());
                String dataXml = builder.toString().replace(jpg.getName(), jpgNew.getName());
                FileWriter fileWriter = new FileWriter(xmlNew);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                writer.write(dataXml);
                writer.flush();
                writer.close();
            }

        }
    }
}
