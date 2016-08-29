public enum CubeType {
    WHITE, BLACK, GLASS;

    @Override
    public String toString() {
        if (this == WHITE) {
            return "W";
        }
        if (this == BLACK) {
            return "D";
        }
        if (this == GLASS) {
            return "G";
        }
        return "_";
    }
}
