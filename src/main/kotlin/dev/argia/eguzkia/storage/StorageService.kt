package dev.argia.eguzkia.storage

interface StorageService {
    /**
     * Initializes this service(e.g. making a root directory).
     */
    fun init()

    /**
     * Reads a file from the storage service.
     *
     * @param path Path from the root directory.
     *
     * @return True if success, False otherwise
     */
    fun read(path: String): ByteArray

    /**
     * Writes data to the storage service.
     *
     * @param path File path from the root directory.
     * @param data Data of the file.
     *
     * @return True if success, False otherwise
     */
    fun write(path: String, data: ByteArray)

    /**
     * Deletes a file from the storage service.
     *
     * @param path File path from the root directory.
     *
     * @return True if success, False otherwise
     */
    fun delete(path: String)
}