class GreekHero
{
    private String _name;
    private int _bravery;
    private int _wisdom;
    private int _strength;
    private int _ferocity;
    private int _fearFactor;
 
    /**
     * Constructor with parameters
     */ 
    public GreekHero(String name, int bravery, int wisdom, 
                     int strength, int ferocity, int fearFactor)
    {
        _name = name;
        _bravery = bravery;
        _wisdom = wisdom;
        _strength = strength;
        _ferocity = ferocity;
        _fearFactor = fearFactor;
    }
    
    /**
     * Accessor method for name
     *
     * @return _name
     */
    public String getName()
    {
        return _name;
    }
  
    /**
     * Accessor method for bravery
     *
     * @return _bravery
     */
    public int getBravery()
    {
        return _bravery;
    }
    
    /**
     * Accessor method for wisdom
     *
     * @return _wisdom
     */
    public int getWisdom()
    {
        return _wisdom;
    }

    /**
     * Accessor method for strength
     *
     * @return _strength
     */
    public int getStrength()
    {
        return _strength;
    }

    /**
     * Accessor method for ferocity
     *
     * @return _ferocity
     */
    public int getFerocity()
    {
        return _ferocity;
    }

    /**
     * Accessor method for fear facto0r
     *
     * @return _fearFactor
     */
    public int getFearFactor()
    {
        return _fearFactor;
    }
  
    /**
     * toString method
     *
     * @return string representation of a GreekHero
     */
    public String toString()
    {
        return "[" + _name + "]\n" + 
             "(a)Bravery:" + _bravery + ", (b)Wisdom:" + _wisdom +
             ", (c)Strength:" + _strength + ", (d)Ferocity:" + _ferocity + 
             ", (e)Fear Factor:" + _fearFactor;
    }
} // end class GreekHero()
    
class GreekHeroArray
{
    private GreekHero[] cards;

    /**
     * Default constructor for the array of GreekHero cards
     */
    public GreekHeroArray()
    {
        cards = new GreekHero[]
        {   
            // bravery, wisdom, strength, ferocity, fear factor
            
            new GreekHero("Achilles",   20,  48,  78, 14, 12),
            new GreekHero("Medusa",      5,  30,  60, 12, 50),
            new GreekHero("Chimera",     5,  10, 140, 20, 48),

            new GreekHero("Polyphemus",  8,  18, 140, 15, 47),
            new GreekHero("Cetus",       5,  14, 150, 16, 45),
            new GreekHero("Zeus",       10, 100, 200,  8, 40),

            new GreekHero("Minotaur",   12,  25, 138, 18, 40),
            new GreekHero("Craeae",      6,  99,  30,  1, 40),
            new GreekHero("Pegasus",    20,  20, 180,  9, 37),

            new GreekHero("Siren",       3,  30, 160,  7, 36),
            new GreekHero("Daphne",     10,  21,  47,  2, 30),
            new GreekHero("Poseidon",   20,  90, 150, 15, 30),

            new GreekHero("Theseus",    26,  38,  75, 10, 12),
            new GreekHero("Odysseus",   30,  56,  65, 10, 11),
            new GreekHero("Perseus",    26,  40,  70,  9, 10),

            new GreekHero("Icarus",     18,  65,  50,  2,  9),
            new GreekHero("Jason",      27,  39,  68,  8,  9),
            new GreekHero("Oedipus",    26,  74,  63,  1,  7),

            new GreekHero("Pandora",    10,  50,  32,  1,  5),
            new GreekHero("Orpheus",    30,  51,  41,  4,  5),
            new GreekHero("Sisyphus",    9,  80,  40,  3,  5),

            new GreekHero("Ariadne",    29,  45,  40,  2,  3),
            new GreekHero("Narcissus",   3,  50,  50,  8,  2),
            new GreekHero("Aphrodite",   9,  49,  40,  6,  2),

            new GreekHero("Trojan Horse", 0,  0, 185, 18, 29),
            new GreekHero("Hermes",     18,  84, 100,  6, 29),
            new GreekHero("Athene",     19,  85, 110,  5, 25),

            new GreekHero("Prometheus", 22,  70,  37,  3, 24),
            new GreekHero("Actaeon",    23,  20,  80,  3, 22),
            new GreekHero("Heracles",   15,  55, 170, 13, 22)
            
        };
    }

    /**
     * Accessor method to the array of GreekHero cards
     *
     * @return array of GreekHero cards created
     */
    public GreekHero[] getCards()
    {
        return cards;
    }

} // end class GreekHeroArray()
