package com.AlbertusTimothyGunawanJSleepKM.dbjson;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;

/**
 * Json Table is used to write and read JSON in every class or method that call json table
 * @param <T> generic as a universal type of data.
 * @author
 */
public class JsonTable<T> extends Vector<T> {
    private static final Gson gson = new Gson();
    public final String filepath;

    /**
     * Creates a new JSON table and loads its data from a file.
     * If the file does not exist, it will be created.
     *
     * @param clazz The type of objects in the table.
     * @param filepath The path to the file containing the data for the table.
     * @throws IOException if there is an error reading or writing the file.
     * @author Albertus Timothy
     */
    @SuppressWarnings("unchecked")
    public JsonTable(Class<T> clazz, String filepath) throws IOException
    {
        this.filepath = filepath;
        try
        {
            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] loaded = readJson(arrayType, filepath);
            if (loaded != null)
                Collections.addAll(this, loaded);
        }
        catch (FileNotFoundException e)
        {
            File file = new File(filepath);
            File parent = file.getParentFile();
            if (parent != null)
                parent.mkdirs();
            file.createNewFile();
        }
    }

    /**
     * Writes the current object to a JSON file at the specified filepath.
     *
     * @throws IOException If an error occurs while writing to the file.
     * @author Albertus Timothy
     */
    public void writeJson() throws IOException
    {
        writeJson(this, this.filepath);
    }

    /**
     * Writes the given object to a JSON file at the specified filepath.
     *
     * @param object The object to write to the JSON file.
     * @param filepath The filepath of the JSON file to write to.
     * @throws IOException If an error occurs while writing to the file.
     * @author Albertus Timothy
     */
    public static void writeJson(Object object, String filepath) throws IOException
    {
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }

    /**
     * Reads and returns an object of the specified class from a JSON file at the given filepath.
     *
     * @param clazz The class of the object to be read from the JSON file.
     * @param filepath The filepath of the JSON file to read from.
     * @param <T> The type of the object to be read from the JSON file.
     * @return The object read from the JSON file.
     * @throws FileNotFoundException If the specified filepath does not exist.
     * @author Albertus Timothy
     */
    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}
