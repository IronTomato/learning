Some JMH Test Result
=====================

Loop
-----  
####Code  

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(".*App.*").forks(1).build();
        new Runner(opt).run();
    }
    private static List<Integer> list;
    
    static{
        list = new ArrayList<>(1000);
        while (list.size() < 1000) {
            list.add(list.size());
        }
    }
    @Benchmark
    public void testForLoop() {
        for (int i = 0; i < 1000; i++) {
            Integer a = list.get(i);
            Integer b = a * a;
        }
    }
    @Benchmark
    public void testForeachLoop() {
        for (Integer a : list) {
            Integer b = a * a;
        }
    }
    @Benchmark
    public void testForeachFunction() {
        list.forEach(a -> {
            Integer b = a * a;
        });
    }

####Result  
	Benchmark                         Mode   Samples        Score  Score error    Units  
	c.w.m.App.testForLoop            thrpt        20   318821.100     4333.367    ops/s  
	c.w.m.App.testForeachFunction    thrpt        20   548407.699     6299.789    ops/s  
	c.w.m.App.testForeachLoop        thrpt        20   335229.439     3997.512    ops/s  


String Concat
------------- 
####Code
    @Benchmark
    public void testStringAdd() {
        String str = "";
        for (int i = 0; i < 100; i++) {
            str = str + i;
        }
    }
    @Benchmark
    public void testStringFormat() {
        String str = "%s";
        for (int i = 0; i < 100; i++) {
            str = String.format(str, i);
        }
    }
    @Benchmark
    public void testStringBuilder() {
        StringBuilder accum = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            accum.append(i);
        }
    }
    @Benchmark
    public void testStringConcat() {
        String str = "";
        for (int i = 0; i < 100; i++) {
            str = str.concat(String.valueOf(i));
        }
    }

####Result
	Benchmark                       Mode   Samples        Score  Score error    Units
	c.w.m.App.testStringAdd        thrpt        20   187305.740     2201.871    ops/s
	c.w.m.App.testStringBuilder    thrpt        20   802729.933     7878.686    ops/s
	c.w.m.App.testStringConcat     thrpt        20   124760.032     3241.229    ops/s
	c.w.m.App.testStringFormat     thrpt        20    27988.334      704.571    ops/s