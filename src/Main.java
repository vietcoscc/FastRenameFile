import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("/home/viet/Downloads/dataout");
        File arrFile[] = file.listFiles();
        for (int i = 0; i < arrFile.length; i++) {
            File imageFile = arrFile[i];
            if (imageFile.getName().endsWith(".jpg")) {
                String name = imageFile.getName();
                File jpg = new File(imageFile.getAbsolutePath());
                File xml = new File(imageFile.getAbsolutePath().replace(".jpg", ".xml"));
//                System.out.println(jpg.getName());
//                System.out.println(xml.getName());
                File jpgNew = new File(jpg.getParent() + "/" + (i + 1111) + ".jpg");
                File xmlNew = new File(xml.getParent() + "/" + (i + 1111) + ".xml");
                System.out.println(jpg.getParent() + "/" + i + ".jpg");
                System.out.println(xml.getParent() + "/" + i + ".xml");
                jpg.renameTo(jpgNew);
                xml.renameTo(xmlNew);
            }

        }
    }

}
