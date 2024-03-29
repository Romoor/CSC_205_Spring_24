class Link {
    public Object data;
    public Link next;

    public Link(Object _data) {
        data = _data;
        next = null;
    }

    public Link(Object _data, Link _next) {
        data = _data;
        next = _next;
    }

}

public class LinkPractice {

    public Object makeTwoLinks(Object x, Object y) {
        Link newLinkY = new Link(x);

        Link newLinkX = new Link(x, newLinkY);
        return newLinkX.data;
    }

}