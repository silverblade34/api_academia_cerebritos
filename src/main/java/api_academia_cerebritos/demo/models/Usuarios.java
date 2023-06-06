package api_academia_cerebritos.demo.models;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.bson.types.ObjectId;
@Document(collection = "Usuarios")
public class Usuarios {
    @Id
    private Integer id;
    @NotBlank(message = "El campo 'codigo' es obligatorio")
    @Field("name")
    private String name;

    @NotBlank(message = "El campo 'codigo' es obligatorio")
    @Field("codigo")
    private String codigo;

    public Usuarios( String name, String codigo) {
        super();
        this.id = id;
        this.name = name;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
