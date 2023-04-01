package dev.argia.eguzkia.storage

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.nio.file.*
import kotlin.io.path.absolute

@Service
class DiskStorageService: StorageService {
    val logger: Logger = LoggerFactory.getLogger(DiskStorageService::class.java)

    val root: Path = Paths.get("uploads")

    override fun init() {
        try {
            Files.createDirectory(root)
            logger.info("Created the root directory: ${root.absolute()}")
        } catch (exception: FileAlreadyExistsException) {
            logger.info("Root directory already exists.")
            // NOTE: Ignoring this exception seems valid, maybe? Skip...
            return
        }
    }

    override fun read(path: String): ByteArray {
        return Files.readAllBytes(root.resolve(path))
    }

    override fun write(path: String, data: ByteArray) {
        Files.write(root.resolve(path), data, StandardOpenOption.CREATE_NEW)
    }

    override fun delete(path: String) {
        TODO("Not yet implemented")
    }
}