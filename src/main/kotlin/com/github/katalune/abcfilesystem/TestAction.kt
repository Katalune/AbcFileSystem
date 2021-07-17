package com.github.katalune.abcfilesystem

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.psi.PsiManager

class TestAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        // TODO: IndexableSetContributor
        // roots contain jar:///Users/kata/IdeaProjects/AbcFileSystem/.jar!/schemas
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
