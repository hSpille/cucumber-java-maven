Feature: Einloggen als vit_gsk
  Als ein Gewebespendekoordinator
  möchte ich mich einloggen
  damit ich Spenderakten bearbeiten kann

  @wip
  Scenario: Einloggen als vit_gsk
    
    Given ich kann die Login Seite sehen 
    When ich logge mich in die Spenderdatenbank ein
    Then sollte ich die Uebersicht sehen

