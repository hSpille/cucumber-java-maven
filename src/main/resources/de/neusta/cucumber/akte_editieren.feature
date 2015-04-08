Feature: Akte Spenderart wird valide 
  Als ein Gewebespendekoordinator
  möchte ich SpenderakteAkten editieren können
  damit ich Spenden erfassen und aendern kann

  @Dev
  Scenario: Neue Akte erstellen, speneart wird valide beim MOD und OG
    
    Given ich bin eingeloggt auf der uebersichtsseite
    When ich eine neue akte erstelle und diese oeffne 
    Then sollte ich die sechs accordions sehen
    When ich die spendeart MOD auswaehle
    When ich den spendetyp OG auswaehle
    When ich die vorgesehene spendeart speichere
    Then sollte vorgesehene spendearten valide sein

