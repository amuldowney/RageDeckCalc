RageDeckCalc
============

ATK Only. Determines best card proc configurations, worst configurations and average attack of a single deck

Has a config file of five cards it takes in, computes the ATK for all 11 skill proc configurations, weighs them based on their probability and reports the individual proc condition ATKs along with the average, also gives the best and worst proc configurations which should highlight any suboptimal deck configurations

PROBLEMS
Does not properly apply bonuses, it applies each skill to cards sequentially, meaning a card getting two 13% boosts will first boost at the cards 100% ATK, then at the cards 113% ATK, which introduces a small amount of ATK inflation
Does not take into account double card procs, as right now the jury is still out on how big of a deduction it will be
Does not take into account skill level for skill procs, the list of proc configurations and probabilities is hardcoded but will need to be dynamically generated to account for skill levels boosting the chances of multi-card proc configurations
