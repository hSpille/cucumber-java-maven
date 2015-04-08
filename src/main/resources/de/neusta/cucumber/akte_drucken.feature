Feature: Ganze Akte Drucken
  Als ein Gewebespendekoordinator
  möchte ich SpenderakteAkten editieren können
  damit ich Spenderakten bearbeiten kann

  @wip
  Scenario: Beliebige Akte drucken
    
    Given ich bin eingeloggt auf der uebersichtsseite 
    When ich eine beliebige Akte oeffne 
    Then sollte ich die sechs accordions sehen
    When ich auf akte drucken klicke
    Then sollte sich ein pdf oeffnen

