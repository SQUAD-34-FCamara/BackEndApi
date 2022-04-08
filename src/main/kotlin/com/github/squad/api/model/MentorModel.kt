package com.github.squad.api.model


import org.hibernate.Hibernate
import javax.persistence.*

@Entity(name = "mentor_model")
data class MentorModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var nome: String,

    @Column
    var email: String,

    @Column
    var senha: String,

    @Column
    @OneToMany
    var especialidades: MutableList<EspecialidadeModel>,

    @Column
    var linkLinkedin: String,

    @Column
    var linkMeet: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as MentorModel

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , nome = $nome , email = $email , senha = $senha , linkLinkedin = $linkLinkedin , linkMeet = $linkMeet )"
    }
}
