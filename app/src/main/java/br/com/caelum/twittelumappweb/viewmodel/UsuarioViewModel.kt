package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioViewModel() : ViewModel() {

    fun loga(usuario: Usuario) {Log.i("Login", usuario.toString())}

    fun cria(usuario: Usuario) {Log.i("Login", usuario.toString())}
}