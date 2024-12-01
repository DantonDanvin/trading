// SimpleEntity.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.testing;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

 public class SimpleEntity {
    private Data data;
    private String status;

    public Data getData() { return data; }
    public void setData(Data value) { this.data = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }
}

// Data.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Data {
    private Stats stats;
    private List<Coin> coins;

    public Stats getStats() { return stats; }
    public void setStats(Stats value) { this.stats = value; }

    public List<Coin> getCoins() { return coins; }
    public void setCoins(List<Coin> value) { this.coins = value; }
}

// Coin.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Coin {
    private String symbol;
    private String marketCap;
    private String color;
    private String change;
    private String btcPrice;
    private long listedAt;
    private String uuid;
    private List<String> sparkline;
    @JsonProperty("24hValue")
    private String coin24hVolume;
    private long tier;
    private String coinrankingUrl;
    private String price;
    private String name;
    private boolean lowVolume;
    private long rank;
    private List<String> contractAddresses;
    private String iconUrl;

    public String getSymbol() { return symbol; }
    public void setSymbol(String value) { this.symbol = value; }

    public String getMarketCap() { return marketCap; }
    public void setMarketCap(String value) { this.marketCap = value; }

    public String getColor() { return color; }
    public void setColor(String value) { this.color = value; }

    public String getChange() { return change; }
    public void setChange(String value) { this.change = value; }

    public String getBtcPrice() { return btcPrice; }
    public void setBtcPrice(String value) { this.btcPrice = value; }

    public long getListedAt() { return listedAt; }
    public void setListedAt(long value) { this.listedAt = value; }

    public String getuuid() { return uuid; }
    public void setuuid(String value) { this.uuid = value; }

    public List<String> getSparkline() { return sparkline; }
    public void setSparkline(List<String> value) { this.sparkline = value; }

    public String get24hVolume() { return coin24hVolume; }
    public void set24hVolume(String value) { this.coin24hVolume = value; }

    public long getTier() { return tier; }
    public void setTier(long value) { this.tier = value; }

    public String getCoinrankingUrl() { return coinrankingUrl; }
    public void setCoinrankingUrl(String value) { this.coinrankingUrl = value; }

    public String getPrice() { return price; }
    public void setPrice(String value) { this.price = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public boolean getLowVolume() { return lowVolume; }
    public void setLowVolume(boolean value) { this.lowVolume = value; }

    public long getRank() { return rank; }
    public void setRank(long value) { this.rank = value; }

    public List<String> getContractAddresses() { return contractAddresses; }
    public void setContractAddresses(List<String> value) { this.contractAddresses = value; }

    public String getIconUrl() { return iconUrl; }
    public void setIconUrl(String value) { this.iconUrl = value; }
}

// Stats.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

class Stats {
    private long total;
    private long totalExchanges;
    private long totalMarkets;
    private String totalMarketCap;
    private String total24hVolume;
    private long totalCoins;

    public long getTotal() { return total; }
    public void setTotal(long value) { this.total = value; }

    public long getTotalExchanges() { return totalExchanges; }
    public void setTotalExchanges(long value) { this.totalExchanges = value; }

    public long getTotalMarkets() { return totalMarkets; }
    public void setTotalMarkets(long value) { this.totalMarkets = value; }

    public String getTotalMarketCap() { return totalMarketCap; }
    public void setTotalMarketCap(String value) { this.totalMarketCap = value; }

    public String getTotal24hVolume() { return total24hVolume; }
    public void setTotal24hVolume(String value) { this.total24hVolume = value; }

    public long getTotalCoins() { return totalCoins; }
    public void setTotalCoins(long value) { this.totalCoins = value; }
}
