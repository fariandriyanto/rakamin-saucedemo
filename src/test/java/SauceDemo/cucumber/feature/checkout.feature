Feature: checkout produk saucedemo

  Scenario: Success Checkout
    Given user masuk ke halaman login
    When user klik tombol add to cart
    And user klik ikon keranjang
    And user klik tombol checkout
    And user input data pelanggan
    And user klik tombol continue
    And user klik tombol finish
    And user klik tombol back to home
    Then berhasil checkout product