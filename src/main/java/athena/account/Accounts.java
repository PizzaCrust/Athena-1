package athena.account;

import athena.account.resource.Account;
import athena.account.service.AccountPublicService;
import athena.exception.EpicGamesErrorException;
import athena.util.request.Requests;
import athena.util.request.Result;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Provides easy access to {@link AccountPublicService}
 */
public final class Accounts {

    /**
     * The service that handles the requests.
     */
    private final AccountPublicService service;

    public Accounts(AccountPublicService accountPublicService) {
        this.service = accountPublicService;
    }

    /**
     * @return the service
     */
    public AccountPublicService service() {
        return service;
    }

    /**
     * Find an account by display name.
     *
     * @param displayName the display name of the account
     * @return a {@link Optional} that will contain the account if found.
     * @throws EpicGamesErrorException if the API returned an error response.
     */
    public Optional<Account> findByDisplayName(String displayName) throws EpicGamesErrorException {
        if (displayName == null) throw new NullPointerException("displayName is null.");
        final var call = service.findByDisplayName(displayName);
        return Requests.executeCallOptional("Failed to find account " + displayName + " by display name.", call);
    }

    /**
     * Find an account by display name.
     *
     * @param displayName the display name of the account
     * @param callback    the callback
     */
    public void findByDisplayNameAsync(String displayName, Result<Account> callback) {
        if (displayName == null || callback == null) throw new NullPointerException("displayName and or result is null.");
        final var call = service.findByDisplayName(displayName);
        Requests.executeCallAsync(call, callback);
    }

    /**
     * Finds an account by account ID.
     *
     * @param accountId the ID of the account.
     * @return a {@link Optional} that will contain the account if found.
     * @throws EpicGamesErrorException if the API returned an error response.
     */
    public Optional<Account> findOneByAccountId(String accountId) throws EpicGamesErrorException {
        if (accountId == null) throw new NullPointerException("accountId is null.");
        final var call = service.findOneByAccountId(accountId);
        return Requests.executeCallOptional("Failed to find account " + accountId + " by account ID.", call);
    }

    /**
     * Find multiple accounts by account ID.
     *
     * @param accounts an array of accounts
     * @return a {@link List} that will NOT be empty if any accounts are found.
     * @throws EpicGamesErrorException if the API returned an error response.
     */
    public List<Account> findManyByAccountId(String... accounts) throws EpicGamesErrorException {
        if (accounts == null) throw new NullPointerException("accounts is null.");
        final var call = service.findManyByAccountId(accounts);
        return Requests.executeCallOptional("Failed to find account(s) by ID(s).", call).orElse(List.of());
    }

    /**
     * Find multiple accounts by account ID.
     *
     * @param accounts a collection of accounts
     * @return a {@link List} that will NOT be empty if any accounts are found.
     * @throws EpicGamesErrorException if the API returned an error response.
     */
    public List<Account> findManyByAccountId(Collection<String> accounts) throws EpicGamesErrorException {
        return findManyByAccountId(accounts.toArray(String[]::new));
    }

}