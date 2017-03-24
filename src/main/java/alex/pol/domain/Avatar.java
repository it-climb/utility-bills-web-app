package alex.pol.domain;

import javax.persistence.*;

@Entity(name = "avatar")
public class Avatar extends BaseModel {

    public String path;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "avatar", fetch = FetchType.LAZY)
    private UserData userData;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}