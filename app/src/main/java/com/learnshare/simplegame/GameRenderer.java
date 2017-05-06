package com.learnshare.simplegame;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.learnshare.simplegame.utils.ShaderHelper;
import com.learnshare.simplegame.utils.TextResourceReader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES20.*;

public class GameRenderer implements GLSurfaceView.Renderer {

    private float [] vertices = {

            // first triangle

            -0.5f,-0.5f,0f ,

            -0.5f , 0.5f , 0f ,

            0.5f , 0.5f , 0f,

            // Second Triangle


            0.5f , 0.5f , 0f,

            0.5f, -0.5f , 0f,

            -0.5f,-0.5f,0f

    };

    private int POSITION_COMPONENT_COUNT = 3 ;

    private FloatBuffer buffer ;

    private Context context;

    private int a_Position_Location , u_Color_Location ;

    private String a_Position = "a_Position", u_Color = "u_Color";

    public GameRenderer(Context context)
    {
        this.context = context;
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

        glClearColor(1f,1f,1f,1.0f);

        buffer = ByteBuffer.allocateDirect(vertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(vertices);

        String vertexShaderSource = TextResourceReader.readTextFromResource(context , R.raw.simple_vertex_shader);

        System.out.println("GameRenderer.onSurfaceCreated:"+ vertexShaderSource);

        String fragmentShaderSource = TextResourceReader.readTextFromResource(context,R.raw.simple_fragment_shader);

        System.out.println("GameRenderer.onSurfaceCreated:"+ fragmentShaderSource);

        int vertexShaderId = ShaderHelper.compileVertexShader(vertexShaderSource);

        int fragmentShaderId = ShaderHelper.compileFragmentShader(fragmentShaderSource);

        System.out.println("GameRenderer.onSurfaceCreated: "+ vertexShaderId + ","+ fragmentShaderId);

        int programId = ShaderHelper.linkProgram(vertexShaderId,fragmentShaderId);

        System.out.println("GameRenderer.onSurfaceCreated:"+ programId);

        glUseProgram(programId);

        a_Position_Location = glGetAttribLocation(programId,a_Position);

        u_Color_Location = glGetUniformLocation(programId,u_Color);

        buffer.position(0);

        glVertexAttribPointer(a_Position_Location,POSITION_COMPONENT_COUNT,GL_FLOAT,false,0,buffer);

        glEnableVertexAttribArray(a_Position_Location);




    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl10) {

        glClear(GL_COLOR_BUFFER_BIT);

        glUniform4f(u_Color_Location,1.0f,1f,0,1.0f);

        glDrawArrays(GL_TRIANGLES,0,6);

    }
}
