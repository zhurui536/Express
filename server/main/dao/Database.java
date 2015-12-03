package main.dao;

import java.io.*;

/**
 * 文件读写
 * Created by Away
 * 2015/11/26
 */

public class Database {

    // 文件路径
    private static String PATH;

    public Database(String path) {
        PATH = path;
    }

    /**
     * 根据路径读出序列化对象，文件为空时返回 null
     * @return 读到的对象
     */
    public Object load() {
        ObjectInputStream ois = null;
        try {
            File file = new File(PATH);
            if (file.length() == 0) {
                return null;
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void save(Object object) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(PATH));
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
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
