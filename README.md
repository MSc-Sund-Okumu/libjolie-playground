# Jolie AST-parsingcontext builder/tester

This repo contains demo.src.java.com.example.App which generates a report of OLSyntaxNodes for which the ParsingContext fails even basic tests.
the report is found in `results/`

The AST for each Jolie program[^1] in `jolie-program/` is printed to a corresponding json file in `results/` in a shorter form with only the OLSyntaxNode's names and the corresponding ParsingContext object.
While a summary report of all the programs is written to `jolie-program/report.md`.

The basic tests mentioned are startColumn and endColumn should in almost every case be different. And the code field should almost always have atleast 1 item.

We may introduce a few False Negatives (if there are cases where a ParsingContext should actually refer to a zero length code etc.). Also there will be incorrect parsingcontexts which are not recognized by this program hence also False Positive.

[^1]: The entry point of each program must be a file called `main.ol`