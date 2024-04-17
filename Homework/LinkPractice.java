package Homework;

class Link {
    public Object data;
    public Link next;

    /*
     * public Link(Object _data) {
     * data = _data;
     * next = null;
     * }
     * 
     * public Link(Object _data, Link _next) {
     * data = _data;
     * next = _next;
     * }
     */

}

public class LinkPractice {

    public Object makeTwoLinks(Object x, Object y) {
        Link newLinkX = new Link();
        Link newLinkY = new Link();

        newLinkX.data = x;
        newLinkY.data = y;

        newLinkX.next = newLinkY;
        newLinkX.next = null;

        return newLinkX;
    }

}