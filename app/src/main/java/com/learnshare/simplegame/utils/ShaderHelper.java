package com.learnshare.simplegame.utils;

import android.opengl.GLES20;

import static android.opengl.GLES20.*;

public class ShaderHelper {

    public static int compileVertexShader(String vertexShaderSource)
    {
        int vertex_shader_id = glCreateShader(GL_VERTEX_SHADER);

        glShaderSource(vertex_shader_id,vertexShaderSource);

        glCompileShader(vertex_shader_id);

        final int [] compileResult = new int [1];

        glGetShaderiv(vertex_shader_id,GL_COMPILE_STATUS,compileResult,0);

        System.out.println("ShaderHelper.compileVertexShader:"+ glGetShaderInfoLog(vertex_shader_id));

        if(compileResult[0]==0)
        {
            return 0 ;
        }
        return vertex_shader_id;
    }

    public static int compileFragmentShader(String fragmentShaderSource)
    {
        int fragment_shader_id = glCreateShader(GL_FRAGMENT_SHADER);

        glShaderSource(fragment_shader_id,fragmentShaderSource);

        glCompileShader(fragment_shader_id);

        final int [] compileResult = new int [1];

        glGetShaderiv(fragment_shader_id,GL_COMPILE_STATUS,compileResult,0);

        System.out.println("ShaderHelper.compileVertexShader:"+ glGetShaderInfoLog(fragment_shader_id));
        if(compileResult[0]==0)
        {
            return 0 ;
        }
        return fragment_shader_id;
    }

    public static int linkProgram (int vertexShaderId , int fragmentShaderId)
    {
        int programId = glCreateProgram() ;

        glAttachShader(programId,vertexShaderId);

        glAttachShader(programId,fragmentShaderId);

        glLinkProgram(programId);

        System.out.println("ShaderHelper.linkProgram:"+ glGetProgramInfoLog(programId));

        int [] linkStatus = new int [1];

        glGetProgramiv(programId,GL_LINK_STATUS,linkStatus,0);

        if(linkStatus[0]==0)
        {
            return 0 ;
        }

        return programId;

    }















}
