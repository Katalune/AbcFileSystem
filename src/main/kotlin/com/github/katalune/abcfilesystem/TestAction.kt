package com.github.katalune.abcfilesystem

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.psi.PsiManager

class TestAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        /*
        * ApkFileSystem
        * Example of existing File System: https://github.com/intellij-rust/intellij-rust/blob/master/src/main/resources/META-INF/rust-core.xml
        * <indexedRootsProvider implementation="org.rust.lang.core.macros.RsIndexableSetContributor"/>
        * <virtualFileSystem key="rust_macros" implementationClass="org.rust.lang.core.macros.MacroExpansionFileSystem"/>
        * <fileTypeOverrider implementation="org.rust.lang.core.macros.RsFileTypeOverriderForMacroExpansionFileSystem"/>
        <globalIndexFilter implementation="org.rust.lang.core.macros.RsGlobalIndexFilterForMacroExpansionFileSystem"/>
        <filetype.prebuiltStubsProvider filetype="Rust"
                                        implementationClass="org.rust.lang.core.macros.MacroExpansionStubsProvider"/>
        */
        // ArhiveFileSystem#getRootByLocal file:///Users/kata/.gradle/caches/transforms-1/files-1.1/runtime-1.1.0.aar/fa4726cf6dd7f7a148c9fb0b13e46bb5/jars/classes.jar
        // indexable roots contain jar:///Users/kata/IdeaProjects/AbcFileSystem/.jar!/schemas
        printFile("abc://" + e.project?.basePath + "/app/libs/arc.abc" + "!/Some.kt", e.project!!)
    }

    private fun printFile(url: String, project: Project) {
        val vf = VirtualFileManager.getInstance().findFileByUrl(url)
        println(vf)
        println(vf?.fileSystem)
        val psiFile = PsiManager.getInstance(project).findFile(vf!!)
        println(psiFile)
        println(psiFile?.text)
    }
}
