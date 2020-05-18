package cn.fuzongyao.learning.springboot.dto;

/**
 * @author fuzongyao
 * @date 2020/05/18
 * @since 1.0.0
 */
public class PostDTO {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public PostDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PostDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PostDTO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
