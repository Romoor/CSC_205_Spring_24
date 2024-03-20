public class PaintCanTest {
    public static void main(String[] args) {
        PaintCan bluePaint = new PaintCan(10, Color.BLUE);
        PaintCan redPaint = new PaintCan(9, Color.RED);
        PaintCan greenPaint = new PaintCan(12, Color.GREEN);

        bluePaint.removePaint(2);
        redPaint.removePaint(2);
        greenPaint.removePaint(2);

        double volume = bluePaint.getPaintVolume() + redPaint.getPaintVolume() + greenPaint.getPaintVolume();

    }
}
