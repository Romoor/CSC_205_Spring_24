public class PaintCan {
    private final int RADIUS = 5;
    private double height;
    private Color color;
    private double paintVolume;

    public PaintCan(double _height, Color _color) {
        height = _height;
        color = _color;
        paintVolume = Math.PI * Math.pow(RADIUS, 2) * height;
    }

    private void emptyPaint() {
        paintVolume = 0;
    }

    public void removePaint(double inches) {
        if (getPaintHeight() <= inches) {
            emptyPaint();
        } else {
            paintVolume -= inches;
        }
    }

    public void addPaint(double inches) {
        if (inches >= getAvailableSpace()) {
            paintVolume = Math.PI * Math.pow(RADIUS, 2) * height;
        } else {
            paintVolume += inches;
        }
    }

    public void addPaintCan(PaintCan paintCan) {
        paintVolume += paintCan.getPaintVolume();
    }

    public int getRadius() {
        return RADIUS;
    }

    public double getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public double getPaintHeight() {
        return paintHeight;
    }

    public double getAvailableSpace() {
        return availableSpace;
    }

    public double getPaintVolume() {
        return paintVolume;
    }
}
