Feature: Akte Oeffnen
  Als ein Gewebespendekoordinator
  möchte ich SpenderakteAkten editieren können
  damit ich Spenderakten bearbeiten kann

  @wip
  Scenario: Beliebige Akte oeffnen
    
    Given ich bin eingeloggt auf der uebersichtsseite 
    When ich eine beliebige Akte oeffne 
    Then sollte ich die sechs accordions sehen

