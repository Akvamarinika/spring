package many_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "child_section",
    joinColumns = @JoinColumn(name = "child_id"),
    inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Child> children;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public void addChild(Child child){
        if (children == null){
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
