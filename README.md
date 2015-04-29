

JMH info from:
http://java-performance.info/jmh/
http://java-performance.info/introduction-jmh-profilers/

Results on a MacBookPro9,2:

[info] # Run complete. Total time: 00:20:21
[info]
[info] Benchmark                                      Mode  Cnt     Score   Error  Units
[info] microWorkflow.Microbenchmark.curly            thrpt  200  1504.358 ± 5.945  ops/s
[info] microWorkflow.Microbenchmark.partialFunction  thrpt  200  1506.714 ± 6.672  ops/s
[info] microWorkflow.Microbenchmark.round            thrpt  200  1502.698 ± 8.368  ops/s