package serialutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 文件读写 Created by Away 2015/11/26
 */

public class Database {

    /**
     * 根据路径读出序列化对象，文件为空时返回 null
     *
     * @return 读到的对象
     */
    public static Object load(String path) {
        ObjectInputStream ois = null;
        try {
            File file = new File(path);
            if (file.length() == 0) {
                return null;
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void save(String path, Object object) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(path + " save error!");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
