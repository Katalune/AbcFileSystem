package com.github.katalune.abcfilesystem

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class AbcFileType : FileType {
    companion object {
        val INSTANCE = AbcFileType()
    }

    override fun getName(): String {
        return "ABC"
    }

    override fun getDescription(): String {
        return "Abc archive"
    }

    override fun getDefaultExtension(): String {
        return "abc"
    }

    override fun getIcon(): Icon? {
        return null
    }

    override fun isBinary(): Boolean {
        return true
    }

    override fun isReadOnly(): Boolean {
        return true
    }

    override fun getCharset(file: VirtualFile, content: ByteArray): String? {
        return null
    }
}
