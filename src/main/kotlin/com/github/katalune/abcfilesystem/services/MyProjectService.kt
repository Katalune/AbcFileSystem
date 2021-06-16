package com.github.katalune.abcfilesystem.services

import com.github.katalune.abcfilesystem.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
