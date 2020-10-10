package com.example.delivers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

    // Recebe uma String e busca na pasta drawable uma imagem com aquele nome para associar a um Imageview;
public class ResourceUtil {
    public static Drawable criaDrawable(Context contexto, String drawableEmTexto ){
        Resources resource = contexto.getResources();
        int idDoDrawable = resource.getIdentifier(drawableEmTexto, "drawable",
                contexto.getPackageName());
        return resource.getDrawable(idDoDrawable);
    }
}
