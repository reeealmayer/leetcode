package child;

import parent.Parent;

public class NotAChild {
    public void check () {
        Parent parent = new Parent();
//        parent.a //нет доступа
    }
}
