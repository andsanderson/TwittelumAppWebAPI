package br.com.caelum.twittelumappweb.modelo

data class Tweet(val mensagem: String,
                 val dono: Usuario,
                 val foto: String?,
                 val latitude: Double=0.0,
                 val longitude: Double=0.0,
                 val id:Long=0) {
    constructor():this("",Usuario(),null,0.0,0.0,0)

    override fun toString(): String {
        return mensagem
    }


}