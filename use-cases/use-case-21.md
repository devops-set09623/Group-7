# USE CASE: 21 Produce a Report on the top N populated capital cities in a continent where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *employee* I want *to produce a report on the top N populated capital cities in a continent where N is provided by the user* so that *I can list the top N populated capital cities in a continent*

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains current country populations.

### Success End Condition

A report is available for employee to view a list of the top N populated capital cities in a continent.

### Failed End Condition

No report is produced.

### Primary Actor

Employee

### Trigger

A request for finance information is sent to HR.

## MAIN SUCCESS SCENARIO

1. Information for capital cities, ordered by population, ascending, is requested.
2. Database creates a report ordering N capital cities in a continent by population.
3. Employee provides report requested.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0