import javax.persistence.*;

@Entity
public class Blog{


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getBlogId() {
        return blogId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", content='" + content + '\'' +
                ", userDetails=" + userDetails +
                '}';
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int blogId;
    String content;

    @OneToOne
    UserDetails userDetails;
}
