package com.github.katalune.abcfilesystem

import com.intellij.openapi.util.text.StringUtil
import com.intellij.openapi.vfs.JarFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.vfs.impl.ArchiveHandler
import com.intellij.openapi.vfs.impl.jar.JarHandler
import com.intellij.openapi.vfs.newvfs.ArchiveFileSystem
import com.intellij.openapi.vfs.newvfs.VfsImplUtil

class AbcFileSystem : ArchiveFileSystem() {
    companion object {
        private const val PROTOCOL = "abc"
        val instance: AbcFileSystem
            get() = VirtualFileManager.getInstance().getFileSystem(PROTOCOL) as AbcFileSystem
    }

    override fun isCorrectFileType(local: VirtualFile): Boolean {
        return local.name.endsWith(".abc")
    }

    override fun getProtocol(): String {
        return PROTOCOL
    }

    override fun findFileByPath(path: String): VirtualFile? {
        val file = VfsImplUtil.findFileByPath(this, path)
        return file
    }

    override fun refresh(asynchronous: Boolean) {
        TODO("Not yet implemented")
    }

    override fun refreshAndFindFileByPath(path: String): VirtualFile? {
        TODO("Not yet implemented")
    }

    override fun extractRootPath(normalizedPath: String): String {
        val separatorIndex = normalizedPath.indexOf(JarFileSystem.JAR_SEPARATOR)
        return if (separatorIndex > 0) normalizedPath.substring(0, separatorIndex + JarFileSystem.JAR_SEPARATOR.length) else normalizedPath
    }

    override fun findFileByPathIfCached(path: String): VirtualFile? {
        TODO("Not yet implemented")
    }

    override fun extractLocalPath(rootPath: String): String {
        return StringUtil.trimEnd(rootPath, JarFileSystem.JAR_SEPARATOR)
    }

    override fun composeRootPath(localPath: String): String {
        return localPath + JarFileSystem.JAR_SEPARATOR
    }

    override fun getHandler(entryFile: VirtualFile): ArchiveHandler {
        return VfsImplUtil.getHandler(this, entryFile, { path: String -> AbcHandler(path) } )
    }
}

class AbcHandler(path: String) : JarHandler(path)
