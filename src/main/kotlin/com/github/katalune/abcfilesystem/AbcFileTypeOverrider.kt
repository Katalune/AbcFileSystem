package com.github.katalune.abcfilesystem

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.impl.FileTypeOverrider
import com.intellij.openapi.vfs.VirtualFile

class AbcFileTypeOverrider : FileTypeOverrider {
    override fun getOverriddenFileType(file: VirtualFile): FileType? {
        return if (file.name.endsWith(".abc")) {
            AbcFileType.INSTANCE
        } else {
            null
        }
    }
}
