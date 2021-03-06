# USE CASE: 5 Produce a Report on the top N populated countries in a continent where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *employee* I want *to produce a report on the top N populated countries in the world where N is provided by the user* so that *I can easily list locations.*

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains current country populations.

### Success End Condition

A report is available for employee to view countries.

### Failed End Condition

No report is produced.

### Primary Actor

Employee.

### Trigger

A request for information is sent to database.

## MAIN SUCCESS SCENARIO

1. Information for countries, ordered by population in a continent, ascending, is requested by the user.
2. Database creates a report ordering all countries by population, displaying the information requested.
3. Employee provides report requested.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0