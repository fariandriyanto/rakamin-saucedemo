Feature: set filter

  Scenario: filter price
    Given user ke halaman login
    When user klik tombol filter
    And user pilih filter price(low to high)
    Then berhasil menerapkan filter