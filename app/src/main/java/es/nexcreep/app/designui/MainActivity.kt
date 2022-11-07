package es.nexcreep.app.designui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val DEFAULT_TAG = "default" // El valor por defecto del tag de imagenAvatar.

    private lateinit var imageAvatar: ImageView // Objeto que contendra el cuador de imagen.
    private lateinit var userAvatar: TextView // Objeto que contendra el campo de texto.
    private lateinit var sendAvatar: Button // Objeto que contendra el boton de acción.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciamos por id los objetos del layout.
        imageAvatar = findViewById(R.id.avatar_image)
        userAvatar = findViewById(R.id.avatar_text)
        sendAvatar = findViewById(R.id.avatar_send)

        imageAvatar.tag = DEFAULT_TAG // Establecemos el tag por inicial de imageAvatar.
        sendAvatar.setOnClickListener { handleImageChange() } // Cuando el boton se pulse ejecuta
                                                              // el metodo handleImageChange().
    }

    /**
     * A partir de el valor que este almacenado en el valor de userAvatar, cambia la imagen con su
     * tag de imageAvatar.
     * */
    private fun handleImageChange() {
        val name = userAvatar.text.toString() // Obtendremos el valor de userAvatar como String.

        // Obtendremos un hashmap con la id y un tag para la imagen, apartir de lo introducido.
        val resource = when (name.lowercase()) {
            "pepe" -> hashMapOf("id" to R.mipmap.pepe,
                                "tag" to "pepeImage")
            "laura" -> hashMapOf("id" to R.mipmap.laura,
                                 "tag" to "lauraImage")
            "maria" -> hashMapOf("id" to R.mipmap.maria,
                                 "tag" to "mariaImage")
            else -> hashMapOf("id" to R.drawable.ic_launcher_foreground,
                              "tag" to DEFAULT_TAG)
        }

        // Si el tag no es el mismo; cambia el recurso de imagen y el tag a imageAvatar.
        if (resource["tag"] != imageAvatar.tag){
            imageAvatar.setImageResource(resource["id"] as Int)
            imageAvatar.tag = resource["tag"] as String
        }

    }
}